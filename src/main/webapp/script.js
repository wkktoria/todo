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

fetch(`${BASE_API_URL}/languages`)
    .then((response) => response.json())
    .then((languages) => {
        languagesContainer.innerHTML = languages.map(language => `
        <label class="pure-radio">
            <input name="language" type="radio" value=${language.id}>
            <img alt="Flag" src=${CODE_TO_FLAG[language.code]}>
        </label>
        `).join("\n");
    })
    .catch(error => console.log(error));

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
});