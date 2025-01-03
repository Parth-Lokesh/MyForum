import React, { useEffect } from "react";
import axios from "axios";
import config from "../../config"

const Profile = () => {

    const [user, setUser] = React.useState(null);

    useEffect(() => {
        axios.defaults.withCredentials = true;
        axios.get(`${config.baseUrl}/profile`)
        .then(response => {
            setUser(response.data)
        }
        )
        .catch(error => {
            console.error("Error occured: ",error)
        })
    }, []); 

    return (
        <div>
            <h2>Profile</h2>
            {user ? (
            <div>
                {user.avatar_url && <img src={user.avatar_url}
                alt="User Profile" referrerPolicy="no-referrer">
                </img>}
                <p><strong>Name : </strong>{user.name}</p>
                {/* <p><strong>Email:</strong>{user.email}</p> */}  
                {/* // Commented this because every user need not to have email, so it will return null */}
            </div>)
            :
            (<p>Loading User Data....</p>)
}
        </div>
    );
}

export default Profile;