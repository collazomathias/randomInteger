

export const fetchRandom = (state) => (dispatch) => {

    dispatch({ type: "view-loading" });
    
    return (
        fetch(`http://localhost:8080/random`, {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(state) // body data type must match "Content-Type" header
        })
        .then(response => response.json())
        .then(json => {
            dispatch({ type: "random-result", data: json });
            dispatch({ type: "view-loaded" });
        })
    )

}