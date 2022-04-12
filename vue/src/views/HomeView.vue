<template class="homepage">
  <div>
    <ul class="container" id="banner">
      <li class="item"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
      <li class="item">FAQ</li>
      <li class="item"><router-link v-bind:to="{ name: 'register' }">Register</router-link></li>
    </ul>
    <h1 class="title">Temp Reading Tracker</h1>
    <h3 class= "subtext">Keep track of your kid's reading. Build habits for life.</h3> 
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>

/*---------------------------------------*/
/* Web Font*/
/*---------------------------------------*/
@import url("httpss://fonts.googleapis.com/css?family=Roboto");

/*---------------------------------------*/
/* Top Banner */
/*---------------------------------------*/
.container {
    display: flex;
    justify-content: space-around;
    margin: 30px auto;
    padding: 30px;
  
}
#banner {
    list-style: none;
    font-family: "Arial Black", Gadget, sans-serif;
    font-size: 17px;
    letter-spacing: 2px;
    word-spacing: 2px;
    color: #000000;
    font-weight: normal;
    text-decoration: none;
    font-style: normal;
    font-variant: small-caps;
    text-transform: none;
}
/*---------------------------------------*/
/* Title and Sub-text */
/*---------------------------------------*/
.title {
text-align: center;
}
.subtext {
  text-align: center;
}
body{
    font-family: "Roboto", sans-serif;
    background: linear-gradient(to right, #96dfe9 0%, #fafafa 50%, #ffffff 99%);
}
.form-register{
  font-family: "Roboto", sans-serif;
    width: 1200px;
    margin: 30px auto;
    background: linear-gradient(to right, #e9f8fa 0%, #fafafa 50%, #ffffff 99%);
    border-radius: 10px;
}
.form-login{
  font-family: "Roboto", sans-serif;
    width: 1200px;
    margin: 30px auto;
    background: linear-gradient(to right, #e9f8fa 0%, #fafafa 50%, #ffffff 99%);
    border-radius: 10px;
}
.form-header {
    background-color: #e2ebf5;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    padding-left: 20px;
}
.form-header h1 {
    font-size: 30px;
    text-align: center;
    color: #666;
    padding-left: 20px;
    border-bottom: 1px solid #cccccc;
}
/*---------------------------------------*/
/* Form Body */
/*---------------------------------------*/
.form-body {
    padding: 20px 40px;
    padding-bottom: 70px;
    margin: 20px;
}
.form-group {
    margin-bottom: 35px;
}
.form-body .label-title {
    color: #1ca3dc;
    font-size: 22px;
    font-weight: bold;
    padding-right: 20px;  

}
.form-body .form-input {
    font-size: 14px;
    box-sizing: border-box;
    width: 60%;
    height: 30px;
    padding-left: 10px;
    padding-right: 10px;
    color: #333333;
    text-align: left;
    border: 1px solid #d6d6d6;
    border-radius: 4px;
    background: white;
    outline: none;
}
.form-body .form-password {
    font-size: 14px;
    box-sizing: border-box;
    width: 35%;
    height: 30px;
    padding-left: 10px;
    padding-right: 10px;
    color: #333333;
    text-align: left;
    border: 1px solid #d6d6d6;
    border-radius: 4px;
    background: white;
    outline: none;
}
.horizontal-group .left {
    float: left;
    width: 59%;
}
.horizontal-group .right {
    float: right;
    width: 40%;
}
.btn-body {
    display: inline-block;
    padding: 10px 10px;
    background-color: #1ca3dc;
    font-size: 17px;
    border: none;
    border-radius: 5px;
    color: #bcf5e7;
    cursor: pointer;
}
.btn-body:hover {
    background-color: #169c7b;
    color: white;
}


/*---------------------------------------*/
/* Form Footer */
/*---------------------------------------*/
.form-footer {
    background-color: #e2ebf5;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
    padding: 40px 10px;
    text-align: right;
    border-top: 1px solid #cccccc;
}
.form-footer span {
    float: right;
    margin-top: 10px;
    color: rgb(204, 38, 38);
    font-style: italic;
    font-weight: thin;
}
.form-footer .btn {
    border: 10px;
    float: right;
    padding: 10px;
    margin-left: 50px;
    margin-right:50px;
    background-color: #1ca3dc;
    font-size: 17px;
    border: none;
    border-radius: 5px;
    color: #bcf5e7;
    cursor: pointer;  
}
.btn:hover {
    background-color: #1ca3dc;
    color: white;
}

</style>
