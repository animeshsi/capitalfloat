# capitalfloat
url -  localhost:10338/discount
requestBody-
{
    "discountCatagory":"cash",
    "isExpired": false,
    "amount" : "9",
    "quantity" :"3",
    "product":
    {
        "id": 2
    }
}

url -localhost:10338/cart
requestBody-
{
    "quantity": 5,
    "user":{"id":1}, 
    "product": {"id":2}
   
}

url -localhost:10338/product
requestBody-
{
    "productName": "apple",
    "quantity": "900",
    "price": "100",
    "category": "fruit"
}
