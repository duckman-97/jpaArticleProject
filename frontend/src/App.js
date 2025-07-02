
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ArticleList from ".//pages/ArticleList";
import ArticleView from ".//pages/ArticleView";
import ArticleWrite from ".//pages/ArticleWrite";
import MainImg from "./components/MainImg";
import Header from "./components/Header";
import Footer from "./components/Footer";
import '/node_modules/bootstrap/dist/css/bootstrap.css';


function App() {

  return (
      <Router>
          <div>
              <Header />
              <MainImg />
              <Routes>
                  <Route path="/" element={<ArticleList/>}/>
                  <Route path="/view/:articleId" element={<ArticleView/>}/>
                  <Route path="/write" element={<ArticleWrite/>}/>
              </Routes>
          </div>
          <Footer/>
      </Router>


  );
}

export default App;
