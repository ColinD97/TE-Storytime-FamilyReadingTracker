<template>
<div class="title">
      <h1>Family Reading Tracker <span>Keep track of your kid's reading. Build habits for life.</span></h1>
        <div class="photo">
          <img src="@/assets/Homepagephoto.png" />
        </div>
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
      
  },
  // computed: {
  // iconUrl () {
  //   return require('../assets/mellowAsset19.jpg')
  //   // The path could be '../assets/img.png', etc., which depends on where your vue file is
  // }

  
};
</script>

<style>


</style>
