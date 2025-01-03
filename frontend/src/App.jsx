import Home from './components/Home'
import Profile from './components/Profile'
import './App.css'
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom'

function App() {

  return (
    <>
      <div className='App'>
        {/* <Home /> */}
        <Router>
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/profile' element={<Profile />} />
          </Routes>
        </Router>
      </div>
    </>
  )
}

export default App
