import { useEffect, useState } from "react";
import { Link } from "react-router-dom";


function ArticleList() {

    const [articles, setArticles] = useState([]);

    useEffect(() => {
        fetch("http://localhost:9090/api/articles")
            .then((res) => res.json())
            .then((data) => setArticles(data))
            .catch((err) => console.error(err));
    }, []);


    return (
        <div>
            <h1>리스트 테스트!!!</h1>
            <ul>
                {articles.map((article) => (
                    <li key={article.articleId}>
                        <Link to={`/view/${article.articleId}`}>
                            {article.articleTitle}
                        </Link>

                    </li>
                ))}
            </ul>
        </div>

    )
}


    export default ArticleList;
