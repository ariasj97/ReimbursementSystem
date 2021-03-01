function viewInfo(){
   
    let xhr = new XMLHttpRequest();

   // let informationHere = document.getElementById("informationHere")
    let url = "/ReimbursementSystem/api/ViewInformation"

    xhr.onreadystatechange = function(){
        if (this.readyState ==4 && this.status==200){
            let information = JSON.parse(xhr.responseText)
            console.log(information)
            let div = document.getElementById('informationHere')
            //for(let i in information ){
            let newInformation = document.createElement('div')
            let userId =document.createElement('p')
            let fname =document.createElement('p')
            let lname =document.createElement('p')
            let phonenumber =document.createElement('p')
            let streetaddress =document.createElement('p') 
            let managerId =document.createElement('p') 

            userId.innerText = information.userId
            fname.innertext = information.fname
            lname.innertext = information.lname
            phonenumber.innertext = information.phonenumber
            streetaddress.innertext = information.streetaddress
            managerId.innertext = information.managerId

            newInformation.append(userId)
            newInformation.append(fname)
            newInformation.append(lname)
            newInformation.append(phonenumber)
            newInformation.append(streetaddress)
            newInformation.append(managerId)
                
            div.append(newInformation)
         //   }
            
        }

        
    }
    xhr.open ("GET", url);
	xhr.send();
}

window.onload = function(){
    viewInfo()
}