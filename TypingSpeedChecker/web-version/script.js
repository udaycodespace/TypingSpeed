let startTime;
let isRunning = false;

function startTest() {
    const text = document.getElementById("text").textContent;
    const input = document.getElementById("input");
    const result = document.getElementById("results");

    if (!isRunning) {
        input.value = "";
        input.disabled = false;
        input.focus();
        result.innerHTML = "";
        isRunning = true;
        startTime = new Date().getTime();
    }

    input.oninput = function() {
        if (input.value.length >= text.length) {
            const endTime = new Date().getTime();
            const timeInMinutes = (endTime - startTime) / 60000.0;
            const typedWords = input.value.trim().split(/\s+/).length;
            const wpm = typedWords / timeInMinutes;

            let correctChars = 0;
            for (let i = 0; i < text.length; i++) {
                if (text[i] === input.value[i]) correctChars++;
            }
            const accuracy = (correctChars / text.length) * 100;

            result.innerHTML = `
                <p>WPM: ${wpm.toFixed(2)}</p>
                <p>Accuracy: ${accuracy.toFixed(2)}%</p>
            `;
            input.disabled = true;
            isRunning = false;
        }
    };
}