

axios.get("http://localhost:8080/api/1/appetizer/all")
  .then(response => {

    const app = document.getElementById('appetizer');

    for (let i = 0; i < response.data.length; i++) {

      const td = document.createElement('td');

      td.textContent = response.data[i].name;

      app.appendChild(td);
    }
    console.table(response.data);

  })
  .catch(error => console.log(error))



