//高效性
//1可选的类型定义
def version = 100

//2.assert
assert version == 100

//3.括号是可选的
println version

//4.字符串
def s1 = 'immoc'
def s2 = "gradle version is ${version}"
//三个单引号可以支持换行
def s3 = '''my
name
is
immoc'''

println s1
println s2
println s3

//5.集合api
//5.1 list
def buildTools = ['ant', 'maven'];
buildTools << 'gradle'
assert buildTools.getClass() == ArrayList
assert buildTools.size() == 3
println buildTools

//5.2 map
def buildYears = ['ant': 2000, 'maven': 2004]
buildYears.gradle = 2009
println buildYears.ant
println buildYears['gradle']
println buildYears.getClass()

//6 闭包
def c1 = {
    v -> println v
}
def c2 = {
    v -> println 'hello'
}

//不要导包
def method1(Closure closure) {
    closure('param')
}

def method2(Closure closure) {
    closure()
}

method1(c1)
method2(c2)



static def method4() {
    println '曹操'
}


//这里的c4相当于def c4 = {it->print "Hello ${it} "    method4()};
c4 = {
    print "Hello ${it}"
    method4()
}

c4.call("我了个大")

