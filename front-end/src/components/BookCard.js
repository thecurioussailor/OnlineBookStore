import React from 'react';

function BookCard({ image, title, writer, price }) {
  return (
    <div className="featured_book_card">
      <div className="featured_book_img">
        <img src={image} alt={title} />
      </div>
      <div className="featured_book_tag">
        <h2>{title}</h2>
        <p className="writer">{writer}</p>
        {/* <div className="categories">{genres.join(', ')}</div> */}
        <p className="book_price">${price.toFixed(2)}</p>
        <a href="#" className="f_btn">
          Learn More
        </a>
      </div>
    </div>
  );
}

export default BookCard;
