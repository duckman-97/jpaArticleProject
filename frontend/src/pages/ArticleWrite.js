import { useState } from "react";
import axios from "axios";

function ArticleWrite() {
    const [articleTitle, setArticleTitle] = useState("");
    const [articleContent, setArticleContent] = useState("");
    const [articleWriter, setArticleWriter] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await axios.post("http://localhost:9090/api/articleSubmit", {
                articleTitle: articleTitle,
                articleContent: articleContent,
                articleWriter: articleWriter,
            });

            alert("등록이 완료되었습니다.")
            window.location.href ="/";
        } catch (error) {
            console.error("에러 발생:", error);
            alert("등록 실패!");
        }
    };

    return (
        <div>
            <h1>게시글 작성</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="articleTitle">제목:</label>
                    <input
                        type="text"
                        id="articleTitle"
                        name="articleTitle"
                        value={articleTitle}
                        onChange={(e) => setArticleTitle(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="articleTitle">작성자:</label>
                    <input
                        type="text"
                        id="articleWriter"
                        name="articleWriter"
                        value={articleWriter}
                        onChange={(e) => setArticleWriter(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="articleContent">내용:</label>
                    <textarea
                        id="articleContent"
                        name="articleContent"
                        rows="5"
                        value={articleContent}
                        onChange={(e) => setArticleContent(e.target.value)}
                    ></textarea>
                </div>
                <button type="submit">등록</button>
            </form>
        </div>
    );
}

export default ArticleWrite;
