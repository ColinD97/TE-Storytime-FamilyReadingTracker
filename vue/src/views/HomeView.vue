<template>
    <div class="title">
    <h1>Family Reading Tracker <span>Keep track of your kid's reading. Build habits for life.</span></h1>
    <img class="home" src="src\assets\mellowAsset19.jpg" alt="reading animal family" style="width:128px;height:128px;">

     <ReadingLog />  <!-- REG'S TEMP CODE TO RENDER READINGLOG.  THIS NEEDS TO BE DELETED -->
     
    </div>




</template>

<script>
// import AppHeader from "./components/Appheader.vue"

import ReadingLog from "@/components/ReadingLog.vue"  // REG'S TEMP CODE TO RENDER READINGLOG.  THIS NEEDS TO BE DELETED -->     

export default {
  name: "home",
  components: {
      
      ReadingLog    // REG'S TEMP CODE TO RENDER READINGLOG.  THIS NEEDS TO BE DELETED -->
      
  }
};
</script>

<style>

/*---------------------------------------*/
/* Web Font*/
/*---------------------------------------*/
@import url("https://fonts.googleapis.com/css?family=Roboto");

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
.title h1{
  text-align:center; font-size:70px; text-transform:uppercase; color:#222; letter-spacing:1px;
  font-family: 'Bubblegum Sans', cursive;
}
.title h1 span {
  margin-top: 5px;
    font-size:25px; color:#444; word-spacing:1px; font-weight:normal; letter-spacing:2px;
    text-transform: uppercase; font-family: 'Bubblegum Sans', cursive;

    display: grid;
    grid-template-columns: 1fr max-content 1fr;
    grid-template-rows: 27px 0;
    grid-gap: 20px;
    align-items: center;
}

.title h1 span:after,.title h1 span:before {
    content: " ";
    display: block;
    border-bottom: 1px solid #ccc;
    border-top: 1px solid #ccc;
    height: 5px;
  background-color:#f8f8f8;
}

body{
    font-family: "Roboto", sans-serif;
    background: linear-gradient(to right, #8ab9bc 0%, #b0dde0 50%, #8ab9bc 99%);
}

/*---------------------------------------*/
/* Forms */
/*---------------------------------------*/
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
    height: 50px;
    background-color: #e2ebf5;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
    padding-left: 20px;
    padding-top: 10px
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
    color: #157788;
    font-size: 22px;
    font-weight: bold;
    padding-right: 20px;  

}
.form-body .form-input {
    font-size: 14px;
    box-sizing: border-box;
    width: 55%;
    height: 30px;
    padding-left: 10px;
    padding-right: 10px;
    color: #333333;
    text-align: left;
    border: 1px solid #d6d6d6;
    border-radius: 6px;
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
    background-color: #157788;
    font-size: 17px;
    border: none;
    border-radius: 10px;
    color: #bcf5e7;
    cursor: pointer;
    
}
.btn-body:hover {
    background-color: #1fc1dd;
    color: white;
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
/*---------------------------------------*/
/* Form Footer */
/*---------------------------------------*/
.form-footer {
    height: 30px;
    background-color: #e2ebf5;
    border-bottom-left-radius: 10px;
    border-bottom-right-radius: 10px;
    text-align: right;
    padding: 20px;
    border-top: 1px solid #cccccc;
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
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
    padding: 8px;
    padding-left: 25px;
    padding-right: 25px;
    margin-left: 50px;
    margin-right:50px;
    margin-bottom: 20px;
    background-color: #1791a7;
    font-size: 17px;
    border: none;
    border-radius: 10px;
    color: #ffffff;
    cursor: pointer;  
}
.btn:hover {
    background-color: #21c4e0;
    color: white;
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
}
.btn {border: 10px;
    float: left;
    padding: 8px;
    padding-left: 25px;
    padding-right: 25px;
    margin-left: 50px;
    margin-right:50px;
    background-color: #157788;
    font-size: 17px;
    border: none;
    border-radius: 10px;
    color: #ffffff;
    cursor: pointer;  
    box-shadow:inset 0 -0.6em 1em -0.35em rgba(0,0,0,0.17),inset 0 0.6em 2em -0.3em rgba(255,255,255,0.15),inset 0 0 0em 0.05em rgba(255,255,255,0.12);
}



</style>
