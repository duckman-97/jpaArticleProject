import { useEffect, useState } from "react";
import { Link } from "react-router-dom";


function Footer() {

    const [articles, setArticles] = useState([]);

    useEffect(() => {
        fetch("http://localhost:9090/api/articles")
            .then((res) => res.json())
            .then((data) => setArticles(data))
            .catch((err) => console.error(err));
    }, []);


    return (

        <footer className="py-5 bg-dark">
            <div className="container"><p className="m-0 text-center text-white">Copyright &copy; Your Website 2023</p>
            </div>
        </footer>

    )
}


export default Footer;
