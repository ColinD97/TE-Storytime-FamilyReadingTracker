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





</style>
