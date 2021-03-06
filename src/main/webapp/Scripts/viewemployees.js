function viewEmployees(){  

    let xhr = new XMLHttpRequest();
    let url = "/ReimbursementSystem/api/ViewEmployees"


    xhr.onreadystatechange = function(){
        if(this.readyState==4 && this.status==200){

            let employees = JSON.parse(xhr.responseText)

            let tbody = document.getElementById('employeesHere')

            console.log(employees);
            for(let e of employees){

                let tr = document.createElement('tr')
                let userId = document.createElement('td')
                let fName = document.createElement('td')
                let lName = document.createElement('td')
                let phoneNumber = document.createElement('td')
                let streetAddress = document.createElement('td')
                let managerId = document.createElement('td')
                let managerfname = document.createElement('td')
                let managerlname = document.createElement('td')
                
                userId.innerHTML = e.userId
                fName.innerHTML = e.fName
                lName.innerHTML = e.lName
                phoneNumber.innerHTML = e.phoneNumber
                streetAddress.innerHTML = e.streetAddress
                managerId.innerHTML = e.managerId.managerId
                managerfname.innerHTML = e.managerId.fname
                managerlname.innerHTML = e.managerId.lname

                tr.append(userId)
                tr.append(fName)
                tr.append(lName)
                tr.append(phoneNumber)
                tr.append(streetAddress)
                tr.append(managerId)
                tr.append(managerfname)
                tr.append(managerlname)
               
                tbody.append(tr)
               
            }
         }
    }
    
    xhr.open('GET',url)
    xhr.send()
}

window.onload = function(){
        viewEmployees()
 }
