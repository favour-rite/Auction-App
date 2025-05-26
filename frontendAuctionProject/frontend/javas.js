document.getElementById('uploadForm').addEventListener('submit', async function (e) {
    e.preventDefault();

    const form = e.target;
    const formData = new FormData(form);

    try {
        const response = await fetch('http://localhost:63342//upload', {
            method: 'POST',
            body: formData,
        });

        const result = await response.json();
        alert(result.message);
    } catch (error) {
        alert('Upload failed');
        console.error(error);
    }
});
const modal = document.getElementById("product-modal");
const closeBtn = document.querySelector(".close-button");
const detailsBtn = document.querySelector(".details-button");

detailsBtn.addEventListener('click', () => {
    modal.style.display = "block";
});

closeBtn.addEventListener('click', () => {
    modal.style.display = "none";
});

window.addEventListener('click', (e) => {
    if (e.target == modal) {
        modal.style.display = "none";
    }
});

