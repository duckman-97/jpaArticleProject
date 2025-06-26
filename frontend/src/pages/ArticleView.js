import { useEffect, useState } from "react";
import {Link, useParams} from "react-router-dom";
import axios from "axios";


function ArticleView() {
    const { articleId } = useParams();
    const [articleData, setArticleData] = useState([])

    useEffect(() => {
        fetch(`http://localhost:9090/api/view/${articleId}`)
            .then((res)=>res.json())
            .then((data) => setArticleData(data))
            .catch((err) => console.error(err));

    }, [articleId]);

    const handleDelete = async ()=>{
        try {
            const response =  axios.post("http://localhost:9090/api/articleDelete", {
                articleId: articleId,
            });
            alert("삭제가 완료되었습니다.")
            window.location.href ="/";
        } catch (error) {
            console.error("에러 발생:", error);
            alert("삭제 실패!");
        }
    }



    return (
        <div>
            <h1>게시글 상세 테스트</h1>
            <h2>{articleData.articleTitle}</h2>
            <p>작성자: {articleData.articleWriter}</p>
            <p>{articleData.articleContent}</p>
            <button type={"button"} onClick={handleDelete}>글삭제</button>
        </div>
    )
}


export default ArticleView;
