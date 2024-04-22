const BASE_URL = "http://localhost:8080/api/hello";
const greetingForm = document.getElementById("greetingForm");
const greetingFormSubmitButton = document.getElementById("greetingFormSubmitButton");
const greeting = document.getElementById("greeting");

greetingFormSubmitButton.addEventListener("click", (event) => {
    event.preventDefault();

    const name = greetingForm.elements["name"].value;
    const language = greetingForm.elements["language"].value;
    const greetingFormObject = {
        name, language
    };

    fetch(`${BASE_URL}/?${new URLSearchParams(greetingFormObject)}`)
        .then((response) => response.text())
        .then((responseText) => {
            greeting.innerText = `${responseText}`;
        }).catch(error => console.error(error));
});