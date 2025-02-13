const express = require('express');
const app = express();
const port = 5000;

app.use(express.json());

let orders = [];
let currentId = 1;

// Create a new order
app.post('/orders', (req, res) => {
    const { customerName, totalPrice } = req.body;
    if (!customerName || typeof totalPrice !== 'number') {
        return res.status(400).send('Invalid data');
    }
    const order = { id: currentId++, customerName, totalPrice };
    orders.push(order);
    res.status(201).send(order);
});

// Get all orders
app.get('/orders', (req, res) => {
    res.status(200).send(orders);
});

// Get an order by ID
app.get('/orders/:id', (req, res) => {
    const order = orders.find(o => o.id === parseInt(req.params.id));
    if (!order) {
        return res.status(404).send();
    }
    res.status(200).send(order);
});

// Update an order by ID
app.put('/orders/:id', (req, res) => {
    const order = orders.find(o => o.id === parseInt(req.params.id));
    if (!order) {
        return res.status(404).send();
    }
    const { customerName, totalPrice } = req.body;
    if (!customerName || typeof totalPrice !== 'number') {
        return res.status(400).send('Invalid data');
    }
    order.customerName = customerName;
    order.totalPrice = totalPrice;
    res.status(200).send(order);
});

// Delete an order by ID
app.delete('/orders/:id', (req, res) => {
    const orderIndex = orders.findIndex(o => o.id === parseInt(req.params.id));
    if (orderIndex === -1) {
        return res.status(404).send();
    }
    orders.splice(orderIndex, 1);
    res.status(200).send();
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}/`);
});