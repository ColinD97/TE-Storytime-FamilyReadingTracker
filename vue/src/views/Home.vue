<template>
  <div class="home">
    <ul id="banner">
      <li><router-link v-bind:to="{ name: 'register' }">Register</router-link></li>
      <li>FAQ</li>
      <li><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
    </ul>
    <h1 id="title">Temp Reading Tracker</h1>
    <h3 id= "subtext">Keep track of your kid's reading. Build habits for life.</h3>
    
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>



<style>
@import url("httpss://fonts.googleapis.com/css?family=Roboto");
#banner {
  list-style: none;
}
#title {
text-align: center;
}
#subtext {
  text-align: center;
}
.home {
    background: linear-gradient(to right, #9dddf7 0%, #85eff5 50%, #ece5ba 99%);
}
.form-register{
  font-family: "Roboto", sans-serif;
    width: 1050px;
    margin: 30px auto;
    background: linear-gradient(to right, #e9f8fa 0%, #fafafa 50%, #ffffff 99%);
    border-radius: 10px;
}
.form-header {
    background-color: #eff0f1;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
.form-header h1 {
    font-size: 30px;
    text-align: center;
    color: #666;
    padding: 20px 0;
    border-bottom: 1px solid #cccccc;
}
/*---------------------------------------*/
/* Form Body */
/*---------------------------------------*/
.form-body {
    padding: 10px 40px;
    color: #666;
}
.form-group {
    margin-bottom: 20px;
}
.form-body .label-title {
    color: #1ca3dc;
    font-size: 17px;
    font-weight: bold;
}
.form-body .form-input {
    font-size: 17px;
    box-sizing: border-box;
    width: 100%;
    height: 34px;
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
    padding: 10px 20px;
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
input[type="file"] {
    outline: none;
    cursor: pointer;
    font-size: 17px;
}
#range-label {
    width: 25%;
    padding: 5px;
    background-color: #1ca3dc;
    color: white;
    border-radius: 5px;
    font-size: 17px;
    position: relative;
    top: -8px;
}

/*---------------------------------------*/
/* Form Footer */
/*---------------------------------------*/
.signup-form .form-footer {
    background-color: #e6d2f1;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
    padding: 10px 40px;
    text-align: right;
    border-top: 1px solid #cccccc;
}
.form-footer span {
    float: left;
    margin-top: 10px;
    color: #999;
    font-style: italic;
    font-weight: thin;
}
.btn {
    display: inline-block;
    padding: 10px 20px;
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
