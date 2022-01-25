import { useState } from 'react';
import { Route, Switch } from 'react-router-dom'

import './App.css';
import Navbar from './components/Navbar';

import Sidebar from './components/Sidebar';
import AddTransactions from './pages/AddTransactions';
import HistoryTransactions from './pages/HistoryTransactions';
import Home from './pages/Home';
import Login from './pages/Login';
import PrivateRoute from './components/PrivateRoute'

function App() {

  const [ isLoggedIn, setIsLoggedIn ] = useState (false)

  function setLogin () {
    setIsLoggedIn (true)
  }

  function logout () {
    localStorage.removeItem ('token')
    setIsLoggedIn (false)
  }

  return (
    <div className="App">
      <header className="App-header">
        <Navbar isLoggedIn={isLoggedIn} logout={logout}></Navbar>
      </header>

      <Sidebar></Sidebar>

      <Switch>
        <Route exact path='/'>
          <Home></Home>
        </Route>
        <PrivateRoute exact path='/add-transaction'>
          <AddTransactions></AddTransactions>
        </PrivateRoute>
        <PrivateRoute exact path='/history-transactions'>
          <HistoryTransactions></HistoryTransactions>
        </PrivateRoute>
        <Route exact path='/login'>
          <Login setLogin={setLogin}></Login>
        </Route>
      </Switch>

    </div>
  );
}

export default App;
