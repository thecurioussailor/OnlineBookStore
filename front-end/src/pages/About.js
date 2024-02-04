import React from 'react'
import aboutImage from '../images/about.png'
import './About.css'
import Header from '../components/Header'
import Footer from '../components/Footer'
function About() {
  return (
    <div>
      
    <div className='about'>
        
        <div className='about-image'>
            <img src={aboutImage}></img>
        </div>
        <div className='about-tag'>
            <h1>About Us</h1>
            <p>
            Welcome to our online book store, your go-to destination for all things literature. At our bookstore, we are passionate about connecting book lovers with their next great read. With an extensive collection of books spanning various genres and subjects, we strive to cater to every reader's unique interests and preferences.
            Our mission is to provide an exceptional reading experience to book enthusiasts worldwide. We curate a diverse selection of books, ranging from bestsellers and classics to niche and independent titles, ensuring there's something for everyone. Whether you're a fiction aficionado, a non-fiction explorer, or a lover of poetry, our wide-ranging catalog is sure to captivate your imagination.
            We pride ourselves on our user-friendly interface, designed to make your browsing and shopping experience effortless. 
            Our intuitive search and navigation features enable you to find the books you're looking for quickly and easily. We also provide detailed book descriptions, author information, and customer reviews to help you make informed decisions and discover new literary gems.
            {/* At our online book store, we believe in fostering a vibrant reading community. We regularly feature author interviews, book recommendations, and literary discussions on our blog and social media platforms. We encourage readers to share their thoughts, engage in conversations, and connect with fellow book lovers who share their passion for the written word.
            Customer satisfaction is our top priority, and we strive to provide exceptional service at every step. From seamless online ordering to secure payment options and reliable shipping, we ensure a hassle-free shopping experience. Our dedicated customer support team is always ready to assist you with any queries or concerns you may have.
            We value the joy of reading and the profound impact books can have on our lives. Through our online book store, we aim to inspire, entertain, and educate readers of all ages. Join us on this literary journey and embark on endless adventures within the pages of our vast collection. Happy reading! */}
            </p>
            <a href='#' className='about-btn'>Learn More</a>
        </div>
    </div>
    </div>
  )
}

export default About