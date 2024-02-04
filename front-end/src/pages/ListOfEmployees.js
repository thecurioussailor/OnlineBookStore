import React, {Component} from 'react'
import axios from 'axios'
import Header from '../components/Header'
import Footer from '../components/Footer'


export class ListOfEmployees extends Component {

    constructor(props){
        super(props)
        this.state = {
            posts:[]
        }
    }

    componentDidMount(){
        axios.get('http://localhost:8080/api/customers')
        .then(response => {
            console.log(response)
        })
        .catch(error => {
            console.log(error)
        })
    }

  render() {
    const { posts } =this.state
    return (
      <div>
        <Header></Header>
        ListOfEmployees
        {
            posts.map(post => <div key={post.id}>{post.title}</div>)
        }
        <Footer></Footer>

      </div>
    )
  }
}

export default ListOfEmployees