package uk.ac.dundee;

import java.lang.reflect.Method;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class Json extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Json() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Object temp = request.getAttribute("Faults");
		Class c = temp.getClass();
		String className = c.getName();
		if (className.compareTo("java.util.ArrayList") == 0) {
			List Data = (List) request.getAttribute("Faults");
			Iterator iterator;
			JSONObject JSONObj = new JSONObject();
			JSONArray Parts = new JSONArray();
			iterator = Data.iterator();
			while (iterator.hasNext()) {
				Object Value = iterator.next();
				JSONObject obj = ProcessObject(Value);
				try {
					Parts.put(obj);
				} catch (Exception JSONet) {
					System.out.println("JSON Fault" + JSONet);
				}
			}
			try {
				JSONObj.put("Faults", Parts);
			} catch (Exception JSONet) {
				System.out.println("JSON Fault" + JSONet);
			}
			if (JSONObj != null) {
				PrintWriter out = response.getWriter();
				out.print(JSONObj);
			}

		} else {
			Object Data = request.getAttribute("Faults");
			JSONObject obj = ProcessObject(Data);
			if (obj != null) {
				PrintWriter out = response.getWriter();
				out.print(obj);
			}
		}
	}

	private JSONObject ProcessObject(Object Value) {
		JSONObject Record = new JSONObject();

		try {
			Class c = Value.getClass();
			Method methlist[] = c.getDeclaredMethods();
			for (int i = 0; i < methlist.length; i++) {
				Method m = methlist[i];
				String mName = m.getName();

				if (mName.startsWith("get") == true) {
					String Name = mName.replaceFirst("get", "");
					Class partypes[] = new Class[0];
					Method meth = c.getMethod(mName, partypes);

					Object rt = meth.invoke(Value);
					if (rt != null) {
						System.out.println(Name + " Return " + rt);
						try {
							Record.put(Name, rt);
						} catch (Exception JSONet) {
							System.out.println("JSON Fault" + JSONet);
							return null;
						}

					}
				}
			}

		} catch (Throwable e) {
			System.err.println(e);
		}
		return Record;
	}

}
