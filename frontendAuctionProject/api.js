const PRODUCT_URL = " https://fakestoreapi.com/products";

const productsContainer = document.querySelector(".products");
// const productWrapper = document.getElementsByClassName("products");

// console.log(productsContainer);
// console.log(productWrapper);

// const getProducts =(url) => {
//     fetch(url)
//     .then((response) => response.json())
//     .then((data)=>{console.log(data)
//         console.log(data)
//
//     })
//     .catch((error) => console.log("Error fetching products:", error));
// };


const getProducts = async (url) => {
    try {
        const response = await fetch(url);
        const data = await response.json();
        displayProducts(data);
    } catch  (error){
        console.log(""+ error);
    }
    
}

getProducts(PRODUCT_URL);

function displayProducts(products){
    products.forEach((product) => {
        console.log(product)
        const {image, title, price, description} = product;
        const productHTML = document.createElement("div");
        productHTML.classList.add("product");
        productHTML.innerHTML =   `
            <img src=" ${image}" alt=""> 
            <div>
                <div>
                    <p>${title} </p>   
                    <p> price: #8345568 ${price} </p> 
                </div>
                <p>${description}</p>
            </div>
         `
        productsContainer.appendChild(productHTML);
    });
}

// function createInnerHTML(productDiv, image, title,price,description) {
//     productDiv.innerHTML =   `
//     <img src=" ${image}" alt=""> 
//     <div>
//         <div>
//             <p>${title} </p>   
//             <p> price: #8345568 ${price} </p> 
//         </div>
//         <p>${description}</p>
//     </div>
//  `
    
//  }