<template>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(person, index) in persons" :key="index">
                <td>{{person.id}}</td>
                <td>{{person.firstName}}</td>
                <td>{{person.lastName}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                persons: []
            }
        },

        created() {
            axios.get(`/backend/person/list`)
                .then(response => {
                    this.persons = response.data;
                });
        }
    }
</script>
//*[@id="content"]/div[1]/div/div/div
<style scoped>

</style>
