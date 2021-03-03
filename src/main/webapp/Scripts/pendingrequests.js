function viewRequests(){

    let xhr = new XMLHttpRequest();

    let url = "/ReimbursementSystem/api/PendingRequests"
    
    let tbody = document.getElementById('requestsHere')
    xhr.onreadystatechange = function(){
        if(this.onreadystate==4 && this.status==200){
            let requests = JSON.parse(xhr.responseText)
            console.log(requests);

            

            for(let r of requests){

                let tr = document.createElement('tr')
                let requestId = document.createElement('td')
                let userId = document.createElement('td')
                let status = document.createElement('td')
                let amount = document.createElement('td')
                let date = document.createElement('td')
                
               

                requestId.innerHTML = r.requestId
                userId.innerHTML = r.userId.userId
                status.innerHTML = r.status
                amount.innerHTML = r.amount
                date.innerHTML = r.date
                
               

                tr.append(requestId)
                tr.append(amount)
                tr.append(date)
                tr.append(status)
                tr.append(userId)
                tbody.append(tr)
            }
         }
    }
    xhr.open('GET',url)
    xhr.send()
}


window.onload = function(){
        viewRequests()
 }
