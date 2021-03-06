function viewRequests(){
    
    let xhr = new XMLHttpRequest();
    let url = "/ReimbursementSystem/api/ViewAllRequests"


    xhr.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){

            let requests = JSON.parse(xhr.responseText)

            let tbody = document.getElementById('requestsHere')

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
                let parseDate = new Date(r.date)
                date.innerHTML = parseDate.getMonth() + "/" + parseDate.getDay() + "/" + parseDate.getFullYear()
                
                tr.append(requestId)
                tr.append(userId)
                tr.append(status)
                tr.append(amount)
                tr.append(date)
               
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
