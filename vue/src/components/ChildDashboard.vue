<template>
  <div class='child-dashboard'>
    <div class="title">
      <h1>{{user.first_name}}'s Dashboard<span>What adventures are we going on today?</span></h1>
    </div>
    <div class="box"> 
        <div class="left-side">
          <div class="grid-item-1">
            <table class="parent">
            <label for="Children"></label>
              <tr>
                <th class='left-end-top'>Child</th>
                <th class='middle'>Books Completed</th>
                <th class='middle'>Minutes Read</th>
                <th class='right-end-top'>Current Book</th>
                <!-- <th class='right-end-top'>Points Balance</th> -->
              </tr>
              <tr>
                <td class='left-end'>{{user.first_name}}</td>
                <td class='middle'>still need</td>
                <td class='middle'>{{user.totalMinutes}}</td>
                <td class='right-end'>still need</td>
                <!-- <td class='right-end'>{{user.pointsBalance}}</td> -->
              </tr>
            </table> 
             </div>
          <img src="@/assets/Dashboard.png" class="grid-item-2"/>
        </div>
        <div class="right-side">
          <reading-log v-bind:familyUsers="familyUsersAll"/>
          <add-book v-bind:familyUsers="familyUsersAll"/>   
        </div> 
  </div>
  </div>
</template>

<script>
import AddBook from "./AddBook.vue";
import ReadingLog from "./ReadingLog.vue";
export default {
  components: { AddBook, ReadingLog },
  data() {
    return {
      user: this.$store.state.user,
      test: "test",
    };
  },
};
</script>

<style>
.box{
  display: flex;
  justify-content: space-around;
}
.parent {
  padding-top: 40px;
  float: left;
  width: 100%;
  justify-content: center;
}
.parent td, .parent th {
  border: 1px solid #f3f7f4;
  padding: 8px;
}
.parent tr:nth-child(even){background-color: #ffffff;}

.parent tr:hover {background-color: #d1e6d6}

.parent th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #126c7c;
  color: #f2f7f3;
}
.left-end{
border-radius: 8px 3px 3px 8px;
}
.middle {
border-radius: 3px 3px 3px 3px;
}
.right-end{
border-radius: 3px 8px 8px 3px;
}
.right-end-top{
border-radius: 3px 8px 5px 3px;
}
.left-end-top {
border-radius: 8px 3px 3px 5px;
}
</style>