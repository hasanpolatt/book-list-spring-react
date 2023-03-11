import './App.css';
import {Component} from "react";
import BookList from "./BookList";

class App extends Component {
  state = { clients: []};

  async componentDidMount() {
    const response = await fetch('/books');
    const body = await response.json();

    this.setState(({books: body}));
  }

  render() {
    return (
        <div>
          <h1>falan</h1>
        </div>
    )
  }
}
export default App;
