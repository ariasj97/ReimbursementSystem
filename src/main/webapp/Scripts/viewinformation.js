function viewInfo(){
   
    let xhr = new XMLHttpRequest();

   // let informationHere = document.getElementById("informationHere")
    let url = "/ReimbursementSystem/api/ViewInformation";
    


    xhr.onreadystatechange = function(){
        if (this.readyState ==4 && this.status==200){

            let information = JSON.parse(xhr.responseText)

            console.log(information)
            let div = document.getElementById('informationHere')
        //for(let i of information ){
            let newInformation = document.createElement('div')
            let userId =document.createElement('p')
            let fname =document.createElement('p')
            let lname =document.createElement('p')
            let phonenumber =document.createElement('p')
            let streetaddress =document.createElement('p') 
            let managerId =document.createElement('p') 
            let managerfname =document.createElement('p') 
            let managerlname =document.createElement('p') 

            userId.innerText = "User ID: " + information.userId
            fname.innerText = "User First Name: " + information .fName
            lname.innerText = "User Last Name: " + information .lName
            phonenumber.innerText = "User Phone Number: " + information .phoneNumber
            streetaddress.innerText = "User Street Address: " + information .streetAddress
            managerId.innerText = "User's Manger's ID:" + information .managerId.managerId
            managerfname.innerText = "User's Manger's First Name: " + information .managerId.fname
            managerlname.innerText = "User's Manager's Last Name: " + information .managerId.lname

            newInformation.append(userId)
            newInformation.append(fname)
            newInformation.append(lname)
            newInformation.append(phonenumber)
            newInformation.append(streetaddress)
            newInformation.append(managerId)
            newInformation.append(managerfname)
            newInformation.append(managerlname)
                    
            div.append(newInformation)
        
            
    }
}

    xhr.open ("GET", url);
	xhr.send();
}

window.onload = function(){
    viewInfo()
}