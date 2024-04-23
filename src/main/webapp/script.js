const BASE_API_URL = "http://localhost:8080/api";
const CODE_TO_FLAG = {
    "en": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/64px-Flag_of_the_United_States.svg.png",
    "pl": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Flag_of_Poland.svg/64px-Flag_of_Poland.svg.png",
    "de": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/64px-Flag_of_Germany.svg.png",
};
const greetingForm = document.getElementById("greetingForm");
const greetingFormSubmitButton = document.getElementById("greetingFormSubmitButton");
const greetingHeading = document.getElementById("greetingHeading");
const languagesContainer = document.getElementById("languagesContainer");
const todosForm = document.getElementById("todosForm");
const todoTextInput = document.getElementById("todoTextInput");
const addTodoButton = document.getElementById("addTodoButton");
const allTodosFieldset = document.getElementById("allTodosFieldset");

const processOkResponse = (response = {}) => {
    if (response.ok) {
        return response.json();
    }
    throw new Error(`${response.text}: ${response.status}`);
};

const initGreetingFormClick = () => {
    greetingFormSubmitButton.addEventListener("click", (event) => {
        event.preventDefault();

        const name = greetingForm.elements["name"].value;
        const language = greetingForm.elements["language"].value;
        const greetingFormObject = {
            name, language
        };

        fetch(`${BASE_API_URL}/hello?${new URLSearchParams(greetingFormObject)}`)
            .then((response) => response.text())
            .then((responseText) => {
                greetingHeading.innerText = `${responseText}`;
            }).catch(error => console.error(error));

        greetingForm.remove();
        todosForm.style.display = "block";
    });
};

const initGreetingForm = () => {
    fetch(`${BASE_API_URL}/languages`)
        .then(processOkResponse)
        .then((languages) => {
            languagesContainer.innerHTML = languages.map(language => `
        <label class="pure-radio">
            <input name="language" type="radio" value=${language.id}>
            <img alt="Flag" src=${CODE_TO_FLAG[language.code]}>
        </label>
        `).join("\n");
        })
        .catch(error => console.log(error));

    initGreetingFormClick();
};

const initTodos = () => {
    fetch(`${BASE_API_URL}/todos`)
        .then(processOkResponse)
        .then(todos => todos.forEach(todo => createNewTodo(todo)))
        .catch(error => console.log(error));
};

initGreetingForm();
initTodos();

const createNewTodo = (todo) => {
    const label = document.createElement("label");
    label.classList.add("pure-checkbox");
    label.classList.add("todo");
    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";
    checkbox.checked = todo.isDone;
    checkbox.classList.add("todo-checkbox");
    checkbox.addEventListener("click", (event) => {
        event.preventDefault();

        fetch(`${BASE_API_URL}/todos/${todo.id}`)
            .then(processOkResponse)
            .then(updatedTodo => checkbox.checked = !!updatedTodo.isDone)
            .catch(error => console.log(error));
    });
    label.appendChild(checkbox);
    label.appendChild(document.createTextNode(todo.text));
    allTodosFieldset.appendChild(label);
};