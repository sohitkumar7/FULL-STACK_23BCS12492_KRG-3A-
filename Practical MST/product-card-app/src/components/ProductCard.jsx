import React from 'react';

const ProductCard = ({ name, price, description, instock }) => {
  return (
    <div className="max-w-sm bg-white rounded-lg shadow-md overflow-hidden m-4 transform transition-transform hover:scale-105">
      <div className="p-6">
        <h3 className="text-xl font-semibold text-gray-900 mb-3">{name}</h3>
        <p className="text-gray-600 text-sm leading-relaxed mb-4">{description}</p>
        <p className="text-2xl font-bold text-green-600 mb-4">${price}</p>
        {instock ? (
          <button className="w-full bg-blue-600 hover:bg-blue-700 text-white font-semibold py-3 px-4 rounded-lg transition duration-200 ease-in-out">
            Buy Now
          </button>
        ) : (
          <div className="w-full bg-red-100 text-red-800 font-semibold py-3 px-4 rounded-lg text-center">
            Out of Stock
          </div>
        )}
      </div>
    </div>
  );
};

export default ProductCard;
