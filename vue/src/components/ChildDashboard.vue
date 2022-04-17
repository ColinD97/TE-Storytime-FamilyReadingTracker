<template>
  <div>
    <div class="title">
      <h1>{{user.first_name}}'s Dashboard</h1>
    </div>
    <table class="parent">
        <label for="Children"></label>
          <tr>
            <th>Child</th>
            <th>Books Completed</th>
            <th>Minutes Read</th>
            <th>Current Book</th>
            <th>Points Balance</th>
          </tr>
          <tr>
            <td>{{user.first_name}}</td>
            <td>still need</td>
            <td>{{user.totalMinutes}}</td>
            <td>still need</td>
            <td>{{user.pointsBalance}}</td>
          </tr>
        </table> 
  </div>
</template>

<script>
export default {
    data() {
        return {
            user: this.$store.state.user,
            test: 'test'
        }
    },

};
</script>

<style>
</style>