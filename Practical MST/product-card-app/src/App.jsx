import React from 'react';
import ProductCard from './components/ProductCard';

function App() {
  const products = [
    { name: 'Product 1', price: 10, description: 'Description 1', instock: true },
    { name: 'Product 2', price: 20, description: 'Description 2', instock: false },
    { name: 'Product 3', price: 30, description: 'Description 3', instock: true },
  ];

  return (
    <div className="min-h-screen bg-gray-100 py-8">
      <div className="max-w-6xl mx-auto px-4">
        <h1 className="text-3xl font-bold text-center text-gray-800 mb-8">Our Products</h1>
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {products.map((product, index) => (
            <ProductCard key={index} {...product} />
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
