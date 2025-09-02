package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    @Override //handler 가 ControllerV4인 경우에만 처리하는 어댑터이다.
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        ControllerV4 controller = (ControllerV4) handler;

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);
        //handler 를 ControllerV4로 케스팅 하고, paramMap, model 을 만들어서 해당 컨트롤러를 호출한다. 그리고 ViewName 을 반환 받는다.

        //어댑터에서 이 부분이 단순하지만 중요한 부분이다.(return mv; 까지)
        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
        //어댑터가 호출하는 ControllerV4는 뷰의 이름을 반환한다. 그런데 어댑터는 뷰의 이름이 아니라 ModelView 를 만들어서 반환해야 한다.
        //여기서 어댑터가 꼭 필요한 이유가 나온다. ControllerV4는 뷰의 이름을 반환했지만, 어댑터는 이것을 ModelView 로 만들어서 형식을
        //맞추어 반환한다. 마치 110v 전기 콘센트를 220v 전기 콘센트로 변경하듯이!
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
