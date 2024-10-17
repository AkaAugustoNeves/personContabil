import Icon from "@mui/material/Icon";
import Competencia from './competencia';

const routes = [
    {
        type: "collapse",
        name: "competencia",
        key: "competencia",
        icon: <Icon fontSize="small">Competência</Icon>,
        route: "/competencia",
        component: <Competencia />,
    },
]

export default routes;