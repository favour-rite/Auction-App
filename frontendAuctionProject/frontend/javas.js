document.getElementById('uploadForm').addEventListener('submit', async function (e) {
    e.preventDefault(); // Prevent page reload

    const form = e.target;
    const formData = new FormData(form); // Collect all fields + file

    try {
        const response = await fetch('http://localhost:63342//upload', {
            method: 'POST',
            body: formData, // Send to backend
        });

        const result = await response.json(); // Parse JSON response
        alert(result.message); // Show success message
    } catch (error) {
        alert('Upload failed');
        console.error(error);
    }
});
