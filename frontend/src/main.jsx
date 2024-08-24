import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
// import './index.css'


const person = {
  name: 'John',
  tel: 25444,
  location: 'New York'
}

const person2 = {
  name: 'John',
  tel: 2522222,
  location: 'New York'
}


const element = 
  <>
    {/* <PersonInfo person={person}/> */}
  </>;


createRoot(document.getElementById('root')).render(
  //<App/>
  <StrictMode>
    <App />
  </StrictMode>,
  //element
)
 