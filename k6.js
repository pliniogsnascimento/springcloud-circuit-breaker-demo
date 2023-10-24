import http from 'k6/http';
import { check, sleep } from 'k6';

 export const options = {
     stages: [
         { duration: '30s', target: 30 },
         { duration: '1m30s', target: 100 },
         { duration: '1m', target: 0 },
     ],
 };

// Populate DB
//export const options = {
//    discardResponseBodies: true,
//    scenarios: {
//        contacts: {
//            executor: 'constant-vus',
//            vus: 10,
//            duration: '2m30s',
//        },
//    },
//};

export default function () {
    const companyName = getCompanyName();

    const body = {
        title: `Developer at ${companyName}`,
        description: `Developer at ${companyName}`,
        enterpriseName: companyName,
        requiredStack: getStack(),
        preferableStack: []
    }

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const res = http.post('http://localhost:8080/v1/jobs', JSON.stringify(body), params);
    console.log(res.status);

    check(res, { 'status was 201': (r) => r.status == 201 });
    sleep(1);
}

const getCompanyName = () => companyNames[parseInt(Math.random() * companyNames.length)];

const getStack = () => {
    const stack = parseInt(Math.random() * 2);
    if (stack == 0) {
        return selectStacks(backendStacks);
    }
    if (stack == 1) {
        return selectStacks(frontendStacks);

    }
    if (stack == 2) {
        return selectStacks(dataStacks);
    } else {
        return getStack()
    }
}

const selectStacks = stackList => {
    const count = parseInt(Math.random() * 6);
    if (count < 2 || count > 5)
        return selectStacks(stackList)

    let stackOut = []
    for (let i = 0; i < count; i++)
        stackOut.push(stackList[parseInt(Math.random() * stackList.length)])

    return stackOut.filter(onlyUnique)
}

const onlyUnique = (value, index, array) => array.indexOf(value) === index


const companyNames = [
    "HappyCompany :)",
    "NewBank",
    "WaterLaundry",
    "Pear",
    "Macrohard",
    "MicroChicker",
]

const frontendStacks = [
    "Javascript",
    "NodeJS",
    "React",
    "Angular",
    "Vue",
    "NextJS",
    "EmberJS",
    "MeteorJS",
    "Express",
]

const backendStacks = [
    "Java",
    "C#",
    "C",
    "C++",
    "Go",
    "Python",
    "Ruby",
    "Ruby on Rails",
    "Scala",
    "Clojure",
    "Rust",
    "V",
]

const dataStacks = [
    "Python",
    "R",
    "Spark",
    "PySpark",
    "Hadoop",
    "Pandas",
    "Jupyter",
    "AWS Glue",
    "TensorFlow",
    "Matplotlib",
    "SAS",
    "DataBricks",
]
