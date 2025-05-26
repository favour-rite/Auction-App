const express = require('express');
const multer = require('multer');
const cors = require('cors');
const app = express();
const port = 8000;

app.use(cors());
app.use(express.json());

const upload = multer({ dest: 'uploads/' });

app.post('/upload', upload.single('productImage'), (req, res) => {
    const productData = req.body;
    const file = req.file;

    console.log('Product Data:', productData);
    console.log('Uploaded File:', file);

    res.json({ message: 'Product uploaded successfully!' });
});


app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});

    document.getElementById("sell-form").addEventListener("submit", function (e) {
    e.preventDefault();

    const item = {
    name: document.getElementById("itemName").value,
    startingPrice: parseFloat(document.getElementById("startingPrice").value),
    auctionStart: document.getElementById("auctionStart").value,
    auctionEnd: document.getElementById("auctionEnd").value,
    description: document.getElementById("description").value,
    category: document.getElementById("category").value,
};

    fetch("http://localhost:8082/api/items", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(item),
})
    .then((res) => res.text())
    .then((message) => alert(message))
    .catch((err) => console.error(err));
});

