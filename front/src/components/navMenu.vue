<template>
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1" @click="allBlogs">首页</el-menu-item>
      <el-menu-item index="2" @click="writeBlog">写博客</el-menu-item>
      <el-menu-item index="3" @click="getProfile">个人简介</el-menu-item>
    </el-menu>
</template>



<script>
    export default {
        data() {
            return {
                activeIndex: '1'
            };
        },
        methods: {
            allBlogs() {
                this.$router.push('/');
            },
            writeBlog()
            {
                this.$router.push('/blogEdit');
            },
            getProfile() {
                this.$router.push('/profile');
            },
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            }
        }
    }
</script>