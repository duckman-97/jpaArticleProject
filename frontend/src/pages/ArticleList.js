import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import button from "bootstrap/js/src/button";


function ArticleList() {

    const [articles, setArticles] = useState([]);

    useEffect(() => {
        fetch("http://localhost:9090/api/articles")
            .then((res) => res.json())
            .then((data) => {
                const today = new Date().toISOString().slice(0, 10); // yyyy-mm-dd


                // 날짜 포맷 적용
                const formatted = data.map((article) => ({
                    ...article,
                    dateData: new Date(article.createdDate).toLocaleString("ko-KR", {
                        year: "numeric",
                        month: "2-digit",
                        day: "2-digit",
                        hour: "2-digit",
                        minute: "2-digit",
                        second: "2-digit",
                    }),
                }));


                setArticles(formatted);
            })
            .catch((err) => console.error(err));
    }, []);


    return (
        <section className="py-5">
            <div className="container px-4 px-lg-5 mt-5">
                <div>
                    <Link to={'/write'}>
                        <button type={button}>글쓰기</button>
                    </Link>

                </div>
                <div className="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    {articles.map((article)=> (
                        <Link to={`/view/${article.articleId}`} style={{ textDecoration: "none", color: "inherit" }}>
                            <div className="col mb-5">
                                <div className="card h-100">

                                    <div className="badge bg-danger text-white position-absolute" style={{ top: "0.5rem", right: "0.5rem" }}>New</div>

                                    <img className="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                                    <div className="card-body p-4">
                                        <div className="text-center">
                                            <h5 className="fw-bolder">{article.articleTitle}</h5>
                                            <div className="d-flex justify-content-center small text-warning mb-2">
                                              {/*  <div className="bi-star-fill">테스트</div>
                                                <div className="bi-star-fill">2</div>
                                                <div className="bi-star-fill">3</div>
                                                <div className="bi-star-fill">4</div>
                                                <div className="bi-star-fill">5</div>*/}
                                            </div>
                                            {article.dateData}
                                        </div>
                                    </div>
                                    <div className="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        {/*<div className="text-center"><a className="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>*/}
                                    </div>
                                </div>
                            </div>
                        </Link>
                    ))}
                </div>
            </div>
        </section>

    )
}


    export default ArticleList;
