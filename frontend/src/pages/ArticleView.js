import { useEffect, useState } from "react";
import {Link, useParams} from "react-router-dom";


function ArticleView() {
    const { articleId } = useParams();
    const [articleData, setArticleData] = useState([])

    useEffect(() => {
        fetch(`http://localhost:9090/api/view/${articleId}`)
            .then((res)=>res.json())
            .then((data) => setArticleData(data))
            .catch((err) => console.error(err));

    }, [articleId]);



    return (
        <div>
            <h1>게시글 상세 테스트</h1>
            <h2>{articleData.articleTitle}</h2>
            <p>작성자: {articleData.articleWriter}</p>
            <p>{articleData.articleContent}</p>
        </div>

    )
}


export default ArticleView;
