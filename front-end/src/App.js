import './App.css';
import Header from './components/Header';
import About from './pages/About';
import Home from './pages/Home';
import Login from './pages/Login'
import ListOfEmployees from './pages/ListOfEmployees';
import {BrowserRouter as Router,
        Routes,
        Route,
        Link,
        BrowserRouter
} from 'react-router-dom';
import Footer from './components/Footer';
import Books from './pages/Books';
import Registration from './pages/Registration';
import Arrival from './pages/Arrival';
function App() {
  return (
    <div className="App">
<Header></Header>
<BrowserRouter>
    <Routes>
      <Route path='/' element={<Home/>}></Route>
      <Route path='/Home' element={<Home/>}></Route>
      <Route path='/About' element={<About/>}></Route>
      <Route path='/Login' element={<Login/>}></Route>
      <Route path='/Arrivals' element={<Arrival/>}></Route>
      <Route path='/Register' element={<Registration/>}></Route>
      {/* <Route path='/Books' element={<Books/>}></Route> */}
    </Routes>
</BrowserRouter>
<Footer></Footer>
    </div>
  );
}

export default App;
