import './App.css';
import {Component} from "react";
import BookList from "./BookList";
import { Route, Router } from "react-router-dom";
import Home from "./Home";
import BookEdit from "./BookEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Route path='/' exath={true} component={Home} />
          <Route path='/books' exact={true} component={BookList}/>
          <Route path='/books/:id' component={BookEdit}/>
        </Router>
    )
  }
}
export default App;
