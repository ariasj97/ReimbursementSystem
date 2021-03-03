function Request(amount, date){
    this.amount = amount
    this.date = date
}

function ajaxPostRequest(){
    let url = "http://localhost:8080/ReimbursementSystem/api/ReimbursementRequest"

    let xhr = new XMLHttpRequest()

    let newAmount = document.getElementById('nAmount').value
    let newDate = document.getElementById('nDate').value

    let newRequest = new Request(newAmount,newDate)

    xhr.onreadystatechange =function(){
        if(xhr.status===200 && xhr.readyState===4){
            console.log("new object sent")
        }
    }

    xhr.open("POST",url)

    xhr.send(JSON.stringify(newRequest))
}

let submissionButton = document.querySelector('button')

submissionButton.addEventListener("click",ajaxPostRequest)