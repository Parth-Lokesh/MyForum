import config from "../../config";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faGithub } from "@fortawesome/free-brands-svg-icons";

const githubLogin = () => {
    window.location.href = `${config.baseUrl}/oauth2/authorization/github`
}

const Home = () => {
    return (
        <div>
            <h2>Welcome to MyForum</h2>
            <button onClick={githubLogin}>
                <FontAwesomeIcon icon={faGithub} style={{ marginRight: "8px" }} />
                Login With GitHub
            </button>
        </div>
    );
}

export default Home;