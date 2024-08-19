import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import App from './App.jsx'
// import './index.css'


const currentDate = new Date();
const hours = currentDate.getHours();
const minutes = currentDate.getMinutes();

const element = <div>{hours}:{minutes}</div>;


createRoot(document.getElementById('root')).render(
  // <StrictMode>
  //   <App />
  // </StrictMode>,
  element
)
 