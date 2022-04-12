<template>
  <div class="parent-dashboard">
      <ul id="banner">
      <li>FAQ</li>
    </ul>
    <h1 id="title">Parent Dashboard</h1>
    <h3 id= "subtext">Keep track of your kid's reading. Build habits for life.</h3>
      <table class="Children List">
      <label for="Children">Children **TABLE OF CHILDREN ACCOUNTS**</label>
        <!-- <tr>
          <th>Name</th>
          <th>Books Finished</th>
          <th>Hours Read</th>
          <th>Last Active?</th>
        </tr>-->
      </table> 

    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create | Edit Child Account IN PROGRESS/WIP
      </button>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create | Edit Parent Account
      </button>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Logout
      </button>

  </div>
</template>

<script>
import authService from "@/services/AuthService";

export default {

}
</script>

<style>

</style>