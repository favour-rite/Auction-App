const express = require('express'); // Backend framework
const multer = require('multer');   // Middleware to handle file uploads
const cors = require('cors');       // Allows frontend on different port to connect
const app = express();
const port = 63342;

app.use(cors());                   // Enable CORS for cross-origin requests
app.use(express.json());           // Parse incoming JSON data

const upload = multer({ dest: 'uploads/' }); // Save files to 'uploads' folder

// POST endpoint to handle the form data
app.post('/upload', upload.single('productImage'), (req, res) => {
    const productData = req.body; // Text fields (name, description, etc.)
    const file = req.file;        // Uploaded file

    console.log('Product Data:', productData);
    console.log('Uploaded File:', file);

    res.json({ message: 'Product uploaded successfully!' });
});

// Start server
app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});
